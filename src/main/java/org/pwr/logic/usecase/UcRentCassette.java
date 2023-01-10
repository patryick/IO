package org.pwr.logic.usecase;

import org.pwr.api.response.RentResponse;
import org.pwr.dataaccess.entity.User;

public interface UcRentCassette {

    RentResponse rentCassette(User user, String cassetteName);
}
