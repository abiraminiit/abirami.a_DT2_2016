package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Controller
public class TestController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productsDAO;
	

	@Autowired
	User user;
	

@RequestMapping("/kill")
public ModelAndView toAdd(){
return new ModelAndView("add");
}

	
	
	@RequestMapping("/adminHome")
	public ModelAndView toAdminHome()

	{
	return new ModelAndView("adminHome");	
	}
	
	
	@RequestMapping("/login")
	public ModelAndView toLogin()

	{
	return new ModelAndView("login");	
	}
	@RequestMapping("/contact")
	public ModelAndView toContact()

	{
	return new ModelAndView("contact");	
	}
	@RequestMapping("/account")
	public ModelAndView toAccount()

	{
	return new ModelAndView("account");
	}
	@RequestMapping("/checkout")
	public ModelAndView toCheckout()

	{
	return new ModelAndView("checkout");	
	}
	@RequestMapping("/index")
	public ModelAndView toIndex()

	{
	return new ModelAndView("index");	
	}
	@RequestMapping("/product")
	public ModelAndView toProduct()

	{
	return new ModelAndView("product");	
	}
	@RequestMapping("/single")
	public ModelAndView toSingle()

	{
	return new ModelAndView("single");	
	}
	@RequestMapping("/typo")
	public ModelAndView toTypo()

	{
	return new ModelAndView("typo");	
	}


	
	
	@RequestMapping(value="/IsValidUser",method=RequestMethod.POST)
	 public ModelAndView executeLogin(@RequestParam("email") String email,@RequestParam("password") String pwd){

		 ModelAndView mv;
		 if(email.equals("abi94@gmail.com"))
		 {
			 mv=new ModelAndView("index");
		 }
			 else {
				 mv=new ModelAndView("register");
				 
			}
		 
	 return mv;
	 }

 
	
@RequestMapping("/allCat")
public ModelAndView toCat()
{
return new ModelAndView("Cat");
}

@RequestMapping("/allUser")
public ModelAndView toUser()
{
return new ModelAndView("User");
}

@RequestMapping("/allProd")
public ModelAndView toProducts()
{
return new ModelAndView("Products");
}


@RequestMapping("/dispProd")
public @ResponseBody String dispProd()
{
List<Product> listProd=productsDAO.list();

Gson g=new Gson();
String Products=g.toJson(listProd);


return Products;   
}

@RequestMapping (value="/savenewcategory")
public ModelAndView newcat (@RequestParam("id") String id,@RequestParam("name") String name){
	 Category cat=new Category();
	 cat.setId(id);
	 cat.setName(name);
	 categoryDAO.saveOrUpdate(cat);
	 
	 ModelAndView mv;
	 return new ModelAndView("Cat");
	 
	 
}


@RequestMapping("/dispUser")
public @ResponseBody String dispUser()
{
List<User> listUser=userDAO.list();

Gson g=new Gson();
String User=g.toJson(listUser);

for(User u:listUser){
	
	System.out.println(u.getId());
	System.out.println(u.getUsername1());
	System.out.println(u.getUtype());
	System.out.println(" next ");
}

return User;
}







@RequestMapping("/dispCat")
public @ResponseBody String dispCategory()
{
List<Category> listCategory=categoryDAO.list();

Gson g=new Gson();
String Cat=g.toJson(listCategory);

for(Category u:listCategory){
	
	System.out.println(u.getId());
	System.out.println(u.getName());
	
	System.out.println(" next ");
}

return Cat;
}




	
	}


