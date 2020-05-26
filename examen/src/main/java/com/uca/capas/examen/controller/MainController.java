package com.uca.capas.examen.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.examen.domain.Categoria;
import com.uca.capas.examen.domain.Libro;
import com.uca.capas.examen.service.CategoriaService;
import com.uca.capas.examen.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	LibroService libroService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public String init() {
		return "inicio";
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView initMain() 
	{
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresarCategoria");
		
		return mav;
	}
	
	@RequestMapping("/guardarCategoria")
	public ModelAndView save(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) 
		{
			mav.setViewName("ingresarCategoria");
		}
		else 
		{
			categoriaService.save(categoria);
			mav.addObject("exitoCategoria", true);
			mav.setViewName("inicio");
		}
		
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresarLibro() 
	{
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> categorias = null;
		
		try {
			categorias = categoriaService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("libro", libro);
		mav.addObject("categorias", categorias);
		mav.setViewName("ingresarLibro");
		
		return mav;
	}
	
	@RequestMapping("/guardarLibro")
	public ModelAndView save(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) 
		{
			List<Categoria> categorias = null;
			
			try {
				categorias = categoriaService.findAll();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("categorias", categorias);
			mav.setViewName("ingresarLibro");
		}
		else 
		{
			libroService.save(libro);
			mav.addObject("exitoLibro", true);
			mav.setViewName("inicio");
		}
		
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView verLibros() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		
		try {
			libros = libroService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("verLibros");
		
		return mav;
	}

}
