package com.constants;

public enum Size {

	S("1"),
	M("2"),
	L("3");
	
	private final String value;
	
	Size(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}
