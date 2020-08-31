package com.socio.repository;

import java.io.Serializable;
import java.util.Objects;

public class SubscriptionId implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 6900147325569601076L;
	private String email;
	private Long club_id;

    public SubscriptionId() {
    }

    public SubscriptionId(String email, Long club_id) {
        this.email = email;
        this.club_id = club_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
        if (o == null || getClass() != o.getClass()) {
			return false;
		}
        SubscriptionId subsId = (SubscriptionId) o;
        return email.equals(subsId.email) &&
        		(club_id ==subsId.club_id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(email, club_id);
    }


}
