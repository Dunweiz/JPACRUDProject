package com.skilldistillery.pethouse.controllers;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		model.addAttribute("pet", pets);
		return "WEB-INF/index.html";
	}
	
	@RequestMapping(path="getPet.do", method = RequestMethod.GET)
	public String showPets(@RequestParam("pid") Integer pid, Model model) {
		PetHouse pet = dao.findById(pid);
		model.addAttribute("pid", pet);
		return "WEB-INF/pet/show.jsp";
	}
	
	@RequestMapping(path="create.do", method = RequestMethod.POST)
	public String createPet(@RequestParam("PID") PetHouse pet, Model model) {
		PetHouse newPet = dao.create(pet);
		model.addAttribute("pet", newPet);
		return "WEB-INF/createnewpet.jsp";
	}
	
	@RequestMapping(path="delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam("PID")int petId, Model model) throws Exception {
		boolean deleted = dao.destroy(petId);
		model.addAttribute("delete", deleted);
		return "delete";
	}
	
	@RequestMapping(path="updatePage.do", method = RequestMethod.POST)
	public String updatePage(@RequestParam("PID") int pId, Model model) {
		PetHouse pet = dao.findById(pId);
		model.addAttribute("pet", pet);
		return "WEB-INF/pet/updatepet.jsp";
	}
	
	@RequestMapping(path="update.do", method=RequestMethod.POST)
	public String updatePet(@RequestParam("PID")int pID, PetHouse pet, Model model) {
		PetHouse newPet = dao.update(pID, pet);
		model.addAttribute("pet", newPet);
		return"WEB-INF/pet/update.jsp";
	}
}
