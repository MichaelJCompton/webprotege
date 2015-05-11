package edu.stanford.bmir.protege.web.shared.sharing;

import com.google.common.base.Objects;
import edu.stanford.bmir.protege.web.shared.user.UserId;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 27/02/2012
 * <p>
 *     Represents a SharingSetting for a particular UserId.
 * </p>
 */
public class UserSharingSetting implements Comparable<UserSharingSetting>, Serializable {

    private UserId userId;
    
    private SharingSetting sharingSetting;

    private UserSharingSetting() {
    }

    /**
     * Constructs a UserSharingSetting which specifies the SharingSetting for a particular UserId.
     * @param userId The UserId which the SharingSetting pertains to.  Must not be <code>null</code>.
     * @param sharingSetting The SharingSetting which pertains the the UserId.  Must not be <code>null</code>.
     * @throws NullPointerException if the userId parameter is <code>null</code> or the sharingSetting parameter
     * is <code>null</code>.
     */
    public UserSharingSetting(UserId userId, SharingSetting sharingSetting) {
        this.userId = checkNotNull(userId);
        this.sharingSetting = checkNotNull(sharingSetting);
    }

    /**
     * Gets the UserId for this UserSharingSetting.
     * @return The UserId. Not <code>null</code>.
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * Gets the SharingSetting for this particular UserSharingSetting.
     * @return The SharingSetting.  Not <code>null</code>.
     */
    public SharingSetting getSharingSetting() {
        return sharingSetting;
    }

    public int compareTo(UserSharingSetting o) {
        return userId.compareTo(o.getUserId());
    }


    @Override
    public String toString() {
        return Objects.toStringHelper("UserSharingSetting")
                .addValue(userId)
                .addValue(sharingSetting)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, sharingSetting);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserSharingSetting)) {
            return false;
        }
        UserSharingSetting other = (UserSharingSetting) obj;
        return this.userId.equals(other.userId) && this.sharingSetting.equals(other.sharingSetting);
    }
}