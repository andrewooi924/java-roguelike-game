package edu.monash.fit2099.engine.displays;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorDeviceConfiguration;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that manages I/O for the system
 */
public class Display  {

	/**
	 * Input
	 */
	private TextGraphics textGraphics;
	private Terminal terminal;
	private TerminalPosition pos;
	private TerminalSize size;
	private Screen screen;
	private static DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
	private static SwingTerminalFrame previousTerminal;

	public void close() {
		try {
			this.terminal.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void refreshScreen() {
		try {
			this.screen.refresh();
			this.screen.clear();
			this.pos = this.pos.withRow(0).withColumn(0);
			Thread.yield();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Display() {
		this("FIT2099");
	}

	public Display(String title) {
		this.pos = new TerminalPosition(0,0);
		// Adjust the size accordingly.
		this.size = new TerminalSize(80, 55);
		try {
			defaultTerminalFactory = defaultTerminalFactory.setInitialTerminalSize(this.size);
			defaultTerminalFactory = defaultTerminalFactory.setTerminalEmulatorTitle(title);
			this.terminal = defaultTerminalFactory.createTerminal();

			if (previousTerminal != null) {
				SwingTerminalFrame a = (SwingTerminalFrame) this.terminal;
				Point prevPoint = previousTerminal.getLocation();
				a.setLocation(prevPoint.x+previousTerminal.getWidth(), prevPoint.y+previousTerminal.getHeight());
			}

			if (terminal instanceof SwingTerminalFrame) {
				previousTerminal = (SwingTerminalFrame) this.terminal;
			}

			this.screen = new TerminalScreen(this.terminal);
			this.screen.startScreen();
			this.screen.setCursorPosition(null);
			this.textGraphics = screen.newTextGraphics();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Display a displayable object.
	 *
	 * @param printable the object to display
	 */
	public void print(Printable printable) {
		textGraphics.putString(this.pos, printable.getDisplayChar()+"");
		this.pos = this.pos.withRelative(1,0);
	}

	/**
	 * Print something without a space
	 *
	 * @param s the string
	 */
	public void print(String s) {
		textGraphics.putString(this.pos, s);
		this.pos = this.pos.withRelative(s.length(),0);
	}

	/**
	 * Prints a String and then terminates the line.
	 * @param s the string to print
	 */
	public void println(String s) {
		this.print(s);
		this.endLine();
	}

	/**
	 * Terminates the line.
	 */
	public void endLine() {
		this.pos = this.pos.withRelative(0,1);
		this.pos = this.pos.withColumn(0);
	}

	/**
	 * Read a char from the keyboard.
	 * 
	 * @return the first char of the next entered string.
	 */
	public char readChar() {
		KeyStroke keyStroke = null;
		Character keyCharacter = null;
		try {
			while (true) {
				keyStroke = this.screen.pollInput();
				keyCharacter = (keyStroke == null) ? null : keyStroke.getCharacter();
			 if(keyCharacter != null) {
			 	return keyCharacter;
			 }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
