package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
@WebServlet(name = "ServletRemoveCart", value = "/RemoveToShoppingCart")
public class ServletRemoveCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) request.getSession().getAttribute("cart");
        String item = request.getParameter("item");
        if (item != null) {
            removeToShoppingCart(cart, item);
        }
        // Retornar la vista con parámetro "selectedItems"
        request.setAttribute("selectedItems", cart);
        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }


    private void removeToShoppingCart(Map<String, Integer> cart, String productKey) {
        int productCount = (Integer)cart.get(productKey).intValue();
        if(productCount<=1) {
            cart.remove(productKey);
        }
        else
        {
            cart.put(productKey, Integer.valueOf(productCount-1));
        }
    }

    private String shoppingCartToHtml(Map<String, Integer> cart) {
        String shoppingCartToHtml = "";
        for (String key: cart.keySet())
            shoppingCartToHtml += "<p>[" + key + "]"+ cart.get(key)+"unidades</p>";
        return shoppingCartToHtml;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
