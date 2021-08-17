package com.alexis.service;

import com.alexis.model.ResetToken;

public interface IResetTokenService {

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
