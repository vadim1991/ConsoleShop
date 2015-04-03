package com.epam.Vadym_Vlasenko.eShop.entity;

public enum Insert {

	NONE, DIAMOND, FIANIT, EMERALD;

	public static Insert choose(int index) {
		
		switch (index) {
		case 0:
			return NONE;
		case 1:
			return DIAMOND;
		case 2:
			return FIANIT;
		case 3:
			return EMERALD;
		default:
			break;
		}
		return NONE;
	}
	
}
