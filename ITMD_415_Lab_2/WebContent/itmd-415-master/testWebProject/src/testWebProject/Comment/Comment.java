package testWebProject.Comment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import testWebProject.lib;
import testWebProject.enums.EtcE;

@Entity
@Table(name = "comment")
public class Comment implements Serializable
{
	private static final long serialVersionUID = 1379680211260170637L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;

	private String name;
	
	private String content;
    
	private long date;

	protected Comment()
	{
		this.name = "Randy Random";
		this.content = "I am a test person. hooray!";
		this.date = lib.nowEpochSecond();
		this.cid = -1;
	}

	protected Comment(int cid, String n, String c, long d)
	{
		this.cid = cid;
		this.name = n;
		this.content = c;
		this.date = d;
	}

	protected Comment(String n, String c, long d)
	{
		this.name = n;
		this.content = c;
		this.date = d;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "comment_id")
	protected int getCid()
	{
		return cid;
	}

	protected void setCid(int cid)
	{
		this.cid = cid;
	}

	protected String getName()
	{
		return name;
	}

	protected void setName(String name)
	{
		this.name = name;
	}

	protected String getContent()
	{
		return content;
	}

	protected void setContent(String content)
	{
		this.content = content;
	}

	/***
	 * @return Date in the form of seconds since Java epoch.
	 */
	protected long getDate()
	{
		return date;
	}

	/***
	 * @return Date in the form of milliseconds since Java epoch.
	 */
	@Transient
	protected long getDatemillis()
	{
		return (this.getDate() * 1000L);
	}
	
	@Transient
	protected String getFormattedDate()
	{
		return lib.epochSecondsToDate(this.getDate(), EtcE.DATEF_HUMAN.s());
	}
	
	protected void setDate(long date)
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		String ret = "";

		ret += String.format("%s on %s: '%s'", this.getName(), this.getDate(), this.getContent());

		return ret;
	}

	/***
	 * Copy all attributes from another comment into self.
	 * 
	 * @param c The other comment.
	 */
	protected void deepCopy(Comment c)
	{
		this.setCid(c.getCid());
		this.setName(c.getName());
		this.setContent(c.getContent());
		this.setDate(c.getDate());
	}

}
