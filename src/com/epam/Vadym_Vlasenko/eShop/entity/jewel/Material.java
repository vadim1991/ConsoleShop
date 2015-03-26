package com.epam.Vadym_Vlasenko.eShop.entity.jewel;

public enum Material {

	WhiteGold, RedGold, Silver;
	
	public static Material choose(int index) {
		switch (index) {
		case 0:
			return WhiteGold;
		case 1:
			return RedGold;
		case 2:
			return Silver;
		default:
			break;
		}
		return null;
	}
	
}
