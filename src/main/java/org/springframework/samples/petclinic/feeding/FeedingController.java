package org.springframework.samples.petclinic.feeding;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {
    
	@Autowired
	private FeedingService feedingService;
	
	@GetMapping(path = "/create")
	public String creategame(ModelMap modelMap) {
		Feeding feeding = new Feeding();
		List<FeedingType> feedingTypes = feedingService.getAllFeedingTypes();
		String view = "feedings/createOrUpdateFeedingForm";
		modelMap.addAttribute("feeding", feeding);
		modelMap.addAttribute("feedingTypes", feedingTypes);
		return view;

	}
	
	@PostMapping(path = "/create")
	public String processProduct(@Valid Feeding feeding, BindingResult result) throws UnfeasibleFeedingException {
		if(result.hasErrors()) {
			return "feedings/createOrUpdateFeedingForm";
		}else {
			feedingService.save(feeding);
			return "redirect:/welcome";
		}

	}
	
}
