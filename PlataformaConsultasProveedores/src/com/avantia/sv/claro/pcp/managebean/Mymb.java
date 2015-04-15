package com.avantia.sv.claro.pcp.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class Mymb {

	private int employeeID;
	private int jobID;
	SelectItem[] itemsJobs = new SelectItem[1];

	public void handleChange() {
		System.out.println("New value: " + getEmployeeID());

		if (getEmployeeID() == 1 || getEmployeeID() == 2) {
			itemsJobs[0] = new SelectItem(1, "Java");
		} else {
			itemsJobs[0] = new SelectItem(2, "RPG");
		}
	}

	public void handleChangeJob() {
		System.out.println("New value: " + getJobID());
	}

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID
	 *            the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public SelectItem[] getEmployeesList() {
		SelectItem[] items = new SelectItem[5];
		items[0] = new SelectItem(1, "Jose");
		items[1] = new SelectItem(2, "Jorge");
		items[2] = new SelectItem(3, "Carlos");
		items[3] = new SelectItem(4, "Mario");
		items[4] = new SelectItem(5, "Edwin");
		return items;
	}

	public SelectItem[] getJobList() {
		return itemsJobs;
	}

	/**
	 * @return the jobID
	 */
	public int getJobID() {
		return jobID;
	}

	/**
	 * @param jobID
	 *            the jobID to set
	 */
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
}