package ors.uds.tpmadkit;

import madkit.kernel.Agent;
import madkit.kernel.Message;

public class QuestionMessage extends Message {
    private static final long serialVersionUID = 1L;
    
	public final Agent sender;
    public final String question;
    
    public QuestionMessage(Agent sender, String question) {
        this.sender = sender;
        this.question = question;
    }
}
