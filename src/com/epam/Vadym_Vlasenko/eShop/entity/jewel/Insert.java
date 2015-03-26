package com.epam.Vadym_Vlasenko.eShop.entity.jewel;

public enum Insert {

	None, Diamond, Fianit, Emerald;

	public static Insert choose(int index) {
		
		switch (index) {
		case 0:
			return None;
		case 1:
			return Diamond;
		case 2:
			return Fianit;
		case 3:
			return Emerald;
		default:
			break;
		}
		return None;
	}
	
}
