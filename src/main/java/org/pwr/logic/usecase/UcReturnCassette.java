package org.pwr.logic.usecase;

import org.pwr.api.response.RentResponse;
import org.pwr.dataaccess.entity.User;

public interface UcReturnCassette {

    RentResponse returnCassette(User user, String cassetteName);
}
