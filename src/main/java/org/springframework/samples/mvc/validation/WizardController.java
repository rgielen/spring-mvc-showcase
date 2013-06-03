package org.springframework.samples.mvc.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * WizardController.
 *
 * @author Rene Gielen
 */
@Controller
@RequestMapping("/registration")
@SessionAttributes("registration")
public class WizardController {

	@RequestMapping
	public void initialPage( ModelMap modelMap ) {
		//..
		return;
	}

	@RequestMapping(params = "_step1")
	public String secondPage( @ModelAttribute("registration")
								  @Validated({Name.class}) Registration registration,
							  BindingResult bindingResult) {
		//..
		return "secondView";
	}

	@RequestMapping(params = "_step2")
	public String thirdPage( @ModelAttribute("registration") @Validated({Address.class}) Registration registration ) {
		//..
		return "secondView";
	}

	@RequestMapping(params = "_final")
	public String finalPage( @ModelAttribute("registration") Registration registration,
							 SessionStatus sessionStatus ) {
		//..
		sessionStatus.setComplete();
		return "thanks";
	}

	@RequestMapping(params = "_cancel")
	public String cancelPage( @ModelAttribute("registration") Registration registration,
							 SessionStatus sessionStatus ) {
		//..
		sessionStatus.setComplete();
		return "cancelled";
	}


}
