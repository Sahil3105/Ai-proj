package com.samart;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIController {
    
    @Autowired
    private OllamaChatModel chatModel;

    @GetMapping("/prompt/{prompt}")
    public Flux<String> sendPrompt(@PathVariable String prompt) {
    	
    	Flux<String> string=chatModel.stream(prompt);
    	
      return string;
    }
}

