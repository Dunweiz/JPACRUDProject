package com.skilldistillery.pethouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.pethouse.data.PetHouseDAO;
import com.skilldistillery.pethouse.entities.PetHouse;

@Controller
public class PetController {

	@Autowired
	private PetHouseDAO dao;
	
	@RequestMapping(path = "/")
	public String index(Model model) {
		List<PetHouse> pets = dao.getAllPets();
		model.addAttribute("pets", pets);
		return "WEB-INF/index.jsp";
	}
	@RequestMapping(path="getPet.do")
	public String showPets(@RequestParam("pid") Integer petId, Model model) {
		PetHouse pet = dao.findById(petId);
		model.addAttribute("pet", pet);
		return "WEB-INF/pet/show.jsp";
	}
}
