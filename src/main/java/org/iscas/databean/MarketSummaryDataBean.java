package org.iscas.databean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

//大盘面板信息的封装bean，Home

public class MarketSummaryDataBean implements Serializable {

	private BigDecimal TSIA; /* Trade Stock Index Average */
	private BigDecimal openTSIA; /* Trade Stock Index Average at the open */
	private double volume; /* volume of shares traded */
	private Collection topGainers; /* Collection of top gaining stocks */
	private Collection topLosers; /* Collection of top losing stocks */
	// FUTURE private Collection topVolume; /* Collection of top stocks by
	// volume */
	private Date summaryDate; /* Date this summary was taken */

	// cache the gainPercent once computed for this bean
	private BigDecimal gainPercent = null;

	public MarketSummaryDataBean() {

	}

	public MarketSummaryDataBean(BigDecimal TSIA, BigDecimal openTSIA, double volume, Collection topGainers,
			Collection topLosers, Date summaryDate, BigDecimal gainPercent) {
		this.TSIA = TSIA;
		this.openTSIA = openTSIA;
		this.volume = volume;
		this.topGainers = topGainers;
		this.topLosers = topLosers;
		this.summaryDate = summaryDate;
		this.gainPercent = gainPercent;
	}

	public BigDecimal getTSIA() {
		return TSIA;
	}

	public void setTSIA(BigDecimal TSIA) {
		this.TSIA = TSIA;
	}

	public BigDecimal getOpenTSIA() {
		return openTSIA;
	}

	public void setOpenTSIA(BigDecimal openTSIA) {
		this.openTSIA = openTSIA;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Collection getTopGainers() {
		return topGainers;
	}

	public void setTopGainers(Collection topGainers) {
		this.topGainers = topGainers;
	}

	public Collection getTopLosers() {
		return topLosers;
	}

	public void setTopLosers(Collection topLosers) {
		this.topLosers = topLosers;
	}

	public Date getSummaryDate() {
		return summaryDate;
	}

	public void setSummaryDate(Date summaryDate) {
		this.summaryDate = summaryDate;
	}

	public BigDecimal getGainPercent() {
		return gainPercent;
	}

	public void setGainPercent(BigDecimal gainPercent) {
		this.gainPercent = gainPercent;
	}
}
