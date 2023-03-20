package com.CtrlAltDefeat;

import java.util.ArrayList;

public class GuitarIterator implements Iterator 
{
	private Guitar guitar;
	private ArrayList<Chord> chordList;
	private int index = 0;
	public GuitarIterator(Guitar guitar)
	{
		this.guitar = guitar;
		chordList = new ArrayList<>();
		chordList.addAll(guitar.getChords());
		
	}
	
	@Override
	public boolean hasNext() {
		
		return index < chordList.size();
	}

	@Override
	public Object next() {
		
		
		if(hasNext()) {
		return chordList.get(index++);
		}
		return null;
	}
}
