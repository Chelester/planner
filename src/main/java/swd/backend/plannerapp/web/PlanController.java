package swd.backend.plannerapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import swd.backend.plannerapp.domain.Plan;
import swd.backend.plannerapp.domain.PlanRepository;

@Controller
public class PlanController {
	@Autowired
	private PlanRepository repository;
	
	@RequestMapping(value={"/", "planner"})
	public String Planner(Model model) {
		model.addAttribute("plans", repository.findAll());
		return "planner";
	}
	
	@RequestMapping(value="/add")
	public String addplan(Model model) {
		model.addAttribute("plan", new Plan());
		return "addplan";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String Editplan(@PathVariable("id")long planId, Model model) {
		model.addAttribute("plan", repository.findById(planId).get());
		return "editplan";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String saveEdit(@PathVariable("id")long id, Plan plan, Model model) {
		plan.setId(id);
		repository.save(plan);
		return "redirect:../planner";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Plan plan) {
		repository.save(plan);
		return "redirect:planner";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String DeletePlan(@PathVariable("id")long planId, Model model) {
		repository.deleteById(planId);
		return "redirect:../planner";
	}
}