package com.example.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.AreaService;
import com.example.service.QuizService;
import com.example.domain.Quiz;
import com.example.form.CreateQuizForm;
import com.example.form.UpdateQuizForm;


/**
 * @author sykn0
 *
 */
@Controller
@RequestMapping("/")
public class QuizController {
	@Autowired 
	private HttpSession session;
	
	@Autowired
	QuizService quizService;

	@Autowired
	AreaService areaService;
	
	@ModelAttribute
	public CreateQuizForm setUpCreateQuizForm() {
		return new CreateQuizForm();
	}
	
	@ModelAttribute
	public UpdateQuizForm setUpUpdateQuizForm() {
		return new UpdateQuizForm();
	}
	
	
	@RequestMapping("/toQuestion")
	public String toQuestion() {
		
		//�o�肷����̃J�e�S���[�������_���Œ��o
		Random random = new Random();
		int category = random.nextInt(3) + 1;
		
		//DB����Y������J�e�S���[�̃N�C�Y��3�������_���Ŏ擾
		List<Quiz> quizList = quizService.findRandom(category);
				
				
		//�o����������_���őI��
		Quiz question = quizList.get(new Random().nextInt(quizList.size()));

		session.setAttribute("question", question);//�o�肷����
		session.setAttribute("quizList", quizList);//�I����
		
		return "/quiz/question";
	}
	
	@RequestMapping("/answer")
	public String answer(String choice, Model model) {
		
		Quiz question = (Quiz) session.getAttribute("question");
		if(question.getAnswerContent().equals(choice)) {
			model.addAttribute("result", "�����ł��I");
		}else {
			model.addAttribute("result", "�c�O�I�s�����ł�");
		}
		return "/quiz/answer";
	}
	
	@RequestMapping("/toManagement")
	public String toManagement() {
		return "/administrator/management_page";
	}
	
	@RequestMapping("/toCreateQuiz")
	public String toCreateQuiz() {
		if(session.getAttribute("administrator") == null) {
			return "/administrator/login";
		}
		session.setAttribute("arealist", areaService.findAll());
		
		return "/quiz/create_quiz";
	}
	
	@RequestMapping("/createQuiz")
	public String createQuiz(@Validated CreateQuizForm form, BindingResult result, Model model) {
		if(session.getAttribute("administrator") == null) {
			return "/administrator/login";
		}
		
		if(result.hasErrors()) {
			if(quizService.findByCategoryAndArea(form.getCategory(), form.getArea()) != null) {
				model.addAttribute("errorMsg", "���̒n��̂��̃J�e�S���[�̖��͊��ɓo�^����Ă��܂�");
			}
			return "/quiz/create_quiz";
		}
		
		if(quizService.findByCategoryAndArea(form.getCategory(), form.getArea()) != null) {
			model.addAttribute("errorMsg", "���̒n��̂��̃J�e�S���[�̖��͊��ɓo�^����Ă��܂�");
			return "/quiz/create_quiz";
		}
		
		Quiz quiz = new Quiz();
		BeanUtils.copyProperties(form, quiz);
		quizService.insert(quiz);
		
		return "/administrator/management_page";
	}
	
	@RequestMapping("/toQuizList")
	public String toQuizList() {
		List<Quiz> quizlist = quizService.findAll();
		session.setAttribute("quizlist", quizlist);
		
		return "/quiz/quiz_list";
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id) {
		Quiz quiz = quizService.findById(id);
		
		session.setAttribute("quiz", quiz);
		
		return "/quiz/update_quiz";
	}
	
	@RequestMapping("/updateQuiz")
	public String updateQuiz(@Validated UpdateQuizForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "/quiz/update_quiz";
		}
		Quiz quiz = (Quiz) session.getAttribute("quiz");
		BeanUtils.copyProperties(form, quiz);
		quizService.update(quiz);
		
		return "redirect:/toQuizList";
	}
	
	@RequestMapping("/toDelete")
	public String toDelete(Integer id) {
		Quiz quiz = quizService.findById(id);
		
		session.setAttribute("quiz", quiz);
		
		return "/quiz/delete_quiz";
	}
	
	@RequestMapping("/deleteQuiz")
	public String delete(Integer id) {
		quizService.delete(id);
		
		return "redirect:/toQuizList";
	}
	
	@RequestMapping("/top")
	public String toTop() {
		return "top";
	}
	
	
}

