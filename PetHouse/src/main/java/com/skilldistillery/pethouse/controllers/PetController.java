package com.skilldistillery.pethouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.pethouse.data.PetHouseDAO;
import com.skilldistillery.pethouse.entities.Pethouse;

@Controller
public class PetController {

	@Autowired
	private PetHouseDAO dao;
	
	@RequestMapping(path = "/")
	public String index(Model model) {
		List<Pethouse> pets = dao.getAllPets();
		model.addAttribute("pets", pets);
		return "WEB-INF/index.jsp";
	}
	
	@RequestMapping(path="getPet.do")
	public String showPets(@RequestParam("pid") Integer pid, Model model) {
		Pethouse pet = dao.findById(pid);
		model.addAttribute("pet", pet);
		return "WEB-INF/pet/show.jsp";
	}
	
	@RequestMapping(path="create.do", method = RequestMethod.POST)
	public String createPet(Pethouse pet, Model model) {
		Pethouse newPet = dao.create(pet);
		model.addAttribute("pet", newPet);
		return "WEB-INF/pet/show.jsp";
	}
	
	@RequestMapping(path="delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam("PID")int petId, Model model) throws Exception {
		System.err.println("*****************" + petId);
		boolean deleted = dao.destroy(petId);
		model.addAttribute("pet", deleted);
		return "WEB-INF/pet/deletepet.jsp";
	}
	
	@RequestMapping(path="updatePage.do")
	public String updatePage(@RequestParam("PID") int pId, Model model) {
		Pethouse pet = dao.findById(pId);
		model.addAttribute("pet", pet);
		return "WEB-INF/pet/updatePage.jsp";
	}
	
	@RequestMapping(path="update.do", method=RequestMethod.POST)
	public String updatePet(@RequestParam("PID")int pID, Pethouse pet, Model model) {
		System.out.println(pet);
		Pethouse newPet = dao.update(pID, pet);
		model.addAttribute("pet", newPet);
		return"WEB-INF/pet/show.jsp";
	}
	@RequestMapping(path="home.do")
	public String home(Model model) {
		List<Pethouse> pets = dao.getAllPets();
		model.addAttribute("pets", pets);
		return "WEB-INF/index.jsp";
	}
	@RequestMapping(path="createPage.do")
	public String redirect() {
		return"WEB-INF/createnewpet.jsp";
	}
	
}
