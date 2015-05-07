package py.com.snowtech.util;

import java.util.Stack;

abstract class ReaderString {
	protected abstract boolean isValid();
	protected abstract void update(char c);
	
	public void readWord(String str) {
		int N = str.length();
		
		for (int i = 0; i<N; i++) update(str.charAt(i));
	}
}

class ClosedTags extends ReaderString {
	private Stack<Character> tags = new Stack<Character>();
	private static final Character openTAGS[] = {'[','{','('};
	private static final Character closedTAGS[] = {']','}',')'};
	
	@Override
	protected boolean isValid() {
		return tags.isEmpty();
	}

	@Override
	protected void update(char item) {
		// if it is an open tag, we just push it into the stack
		if (contains(openTAGS, item) > -1) {
			tags.push(item);
		} else {
			int pos = contains(closedTAGS, item);
			if (pos > -1) {
				// it's a close tag, check if it's open tag is at top
				if (tags.peek() == openTAGS[pos])
					tags.pop();
			}
		}
	}
	
	private int contains(Character[] list, Character c) {
		int index = 0;
		for (Character charc : list) {
			if (charc == c) return index;
			index++;
		}
		
		return -1;
	}
}

//simplier than observed, but slower than observer if
//you need to check other stuffs at reading text
public class AMZIntView {
	public static void main(String[] args) {
		ReaderString str = new ClosedTags();
		
		str.readWord("zdvvd [({gewaaage})]{aaaa");
	}
}
