package model;
import java.util.Iterator;


public interface Command {
	public void execute(Iterator args);
}
