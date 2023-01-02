package ors.uds.tpmadkit;

import madkit.kernel.Agent;
import madkit.kernel.Message;

public class AnswerMessage extends Message {
    private static final long serialVersionUID = 1L;
    
    public final Agent responder;
	public final String answer;
	
    public AnswerMessage(String answer, Agent responder) {
        this.responder = responder;
		this.answer = answer;
    }
    
    
}