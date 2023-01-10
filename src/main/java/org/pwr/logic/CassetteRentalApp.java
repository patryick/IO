package org.pwr.logic;

import org.pwr.logic.usecase.UcCreateUserAccount;
import org.pwr.logic.usecase.UcRentCassette;
import org.pwr.logic.usecase.UcReturnCassette;

public interface CassetteRentalApp extends UcReturnCassette, UcRentCassette, UcCreateUserAccount {
}
