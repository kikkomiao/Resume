package Entity;
import java.util.Date;

public class Resume {//封装表单信息的JavaBean
	private int id;
	private String title;
	private String userphone;
	private String name;
	private int gender;
	private int age;
	private String pic;
	private String phone;
	private String email;
	private String target;
	private int politic;
	private String school;
	private String major;
	private String time;
	private String award;
	private String skill;


	public Resume() {

	}

	public Resume(int id, String title, String userphone, String name, int gender, int age, String pic, String phone, String email, String target, int politic, String school, String major, String time, String award, String skill) {
		this.id = id;
		this.title = title;
		this.userphone = userphone;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pic = pic;
		this.phone = phone;
		this.email = email;
		this.target = target;
		this.politic = politic;
		this.school = school;
		this.major = major;
		this.time = time;
		this.award = award;
		this.skill = skill;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getPolitic() {
		return politic;
	}

	public void setPolitic(int politic) {
		this.politic = politic;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String toString() {
		return "Resume [title=" + title + ", userphone=" + userphone + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", pic=" + pic + ", phone=" + phone + ", email="
				+ email + ", target=" + target + ", politic=" + politic + ", school=" + school + ", major="
				+ major + ", time=" + time + ", award=" + award + ", skill=" + skill + "]";
	}

}
