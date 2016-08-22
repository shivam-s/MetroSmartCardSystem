package delhi.metro.system.beans;

import java.util.Calendar;

import delhi.metro.system.fare.strategies.FareStrategy;


/**
 * @author Shivam
 * this class is to have the complete transaction of a single trip.
 *
 */
public class CardTransaction {
	private int cardTxnId;
	private MetroCard card;
	private Station sourceStation;
	private Station destinationStation;
	private Calendar startTime;
	private Calendar endTime;
	private double balance;
	private double fare;
	private FareStrategy fairStrategyUsed;

	public int getCardTxnId() {
		return cardTxnId;
	}

	public void setCardTxnId(int cardTxnId) {
		this.cardTxnId = cardTxnId;
	}

	public MetroCard getCard() {
		return card;
	}

	public void setCard(MetroCard card) {
		this.card = card;
	}

	public Station getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(Station sourceStation) {
		this.sourceStation = sourceStation;
	}

	public Station getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public FareStrategy getFairStrategyUsed() {
		return fairStrategyUsed;
	}

	public void setFairStrategyUsed(FareStrategy fairStrategyUsed) {
		this.fairStrategyUsed = fairStrategyUsed;
	}

	@Override
	public String toString() {
		return "CardTransaction [cardTxnId=" + cardTxnId + ", card=" + card
				+ ", sourceStation=" + sourceStation + ", destinationStation="
				+ destinationStation + ", startTime="
				+ (startTime != null ? startTime.getTime() : null)
				+ ", endTime=" + (endTime != null ? endTime.getTime() : null)
				+ ", balance=" + balance + ", fare=" + fare
				+ ", fairStrategyUsed=" + fairStrategyUsed + "]";
	}
}
