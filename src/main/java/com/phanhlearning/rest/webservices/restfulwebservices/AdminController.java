//package com.phanhlearning.rest.webservices.restfulwebservices;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//@Controller
//public class AdminController {
//    @Autowired
//    private RequestMappingHandlerMapping requestMappingHandlerMapping;
//
//    @RequestMapping( value = "endPoints", method = RequestMethod.GET )
//    public String getEndPointsInView( Model model )
//    {
//        model.addAttribute( "endPoints", requestMappingHandlerMapping.getHandlerMethods().keySet() );
//        return "admin/endPoints";
//    }
//}
