package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PracticeModel {

    @GetMapping("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }

    // need a controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/showForm2")
    public String showForm2() {
        return "helloworld-form-version3";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "process";
    }

    // need a controller method to read form data and
    // add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "process";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam String studentName, Model model) {

    // convert the data to all caps
    studentName = studentName.toUpperCase();

        // create the message
        String result = "Yo! using Request Param  " + studentName;

        // add message to the model
        model.addAttribute("message", result);

        return "process";
    }
}
