package com.epam.Vadym_Vlasenko.eShop.entity;

public enum Material {

	WHITE_GOLD, RED_GOLD, SILVER;
	
	public static Material choose(int index) {
		switch (index) {
		case 0:
			return WHITE_GOLD;
		case 1:
			return RED_GOLD;
		case 2:
			return SILVER;
		default:
			break;
		}
		return null;
	}
	
}
