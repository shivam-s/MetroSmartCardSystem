package delhi.metro.system.beans;


/**
 * @author Shivam
 * This is pojo for Metro Smart Card
 *
 */
public class MetroCard {

	private long cardId;
	private double balance;
	private Traveller traveller;

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}

	@Override
	public boolean equals(Object mc) {
		if (mc == null) {
			return false;
		}
		if (this.getClass() == mc.getClass()) {
			return true;
		}
		if (this.getCardId() == ((MetroCard) mc).getCardId()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Long.valueOf(this.getCardId()).intValue() + super.hashCode();
	}

	@Override
	public String toString() {
		return "MetroCard [cardId=" + cardId + ", balance=" + balance
				+ ", traveller=" + traveller + "]";
	}

}
