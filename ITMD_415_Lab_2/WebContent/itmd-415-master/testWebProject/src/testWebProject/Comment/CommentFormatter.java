package testWebProject.Comment;

import testWebProject.lib;
import testWebProject.enums.TagE;

public class CommentFormatter
{
	/***
	 * Formats a single comment as one HTML element.
	 */
	public static String formatComment(Comment c)
	{
		String ret = "";

		String name = lib.wrap(c.getName(), TagE.TAG_H2.s());
		
		String date = lib.wrap(c.getFormattedDate(), TagE.TAG_A.s());
		
		String comment = lib.wrap(c.getContent(), TagE.TAG_Q.s());
		
		ret += name + date + comment;

		return ret;
	}
}
