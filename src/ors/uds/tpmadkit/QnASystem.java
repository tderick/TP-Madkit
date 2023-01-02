package ors.uds.tpmadkit;

import madkit.kernel.Madkit;
import madkit.kernel.Madkit.Option;

public class QnASystem {
	public static void main(String[] args) {
		  // lancer MadKit
	
			new Madkit(Option.launchAgents.toString(),
					QuestionerAgent.class.getName() + ",true,3;"+ResponderAgent.class.getName() + ",false,3;");
	}
}
