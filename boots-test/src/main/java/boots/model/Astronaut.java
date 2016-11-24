package boots.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="astronaut")
public class Astronaut implements Serializable{

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int astronautId;
		@Column(length=45)
		private String astronautName;
		@Column(length=45)
		private String age;
		@Temporal(TemporalType.DATE)
		@Column(name="date_register")
		private Date dateRegister;
		private boolean status;
		
		public Astronaut(String AstronautName, String age, Date dateRegister, boolean status) {
			super();
			this.astronautName = AstronautName;
			this.age = age;
			this.dateRegister = dateRegister;
			this.status = status;
		}
		
		public Astronaut(){
			this("","",new Date(),false);
		}

		public int getAstronautId() {
			return astronautId;
		}

		public void setAstronautId(int astronautId) {
			this.astronautId = astronautId;
		}

		public String getAstronautName() {
			return astronautName;
		}

		public void setAstronautName(String astronautName) {
			this.astronautName = astronautName;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public Date getDateRegister() {
			return dateRegister;
		}

		public void setDateRegister(Date dateRegister) {
			this.dateRegister = dateRegister;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Astronaut [astronautId=" + astronautId + ", astronautName=" + astronautName + ", age=" + age
					+ ", dateRegister=" + dateRegister + ", status=" + status + "]";
		}

		
		
		
	
}
