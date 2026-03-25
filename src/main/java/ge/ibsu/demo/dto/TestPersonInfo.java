package ge.ibsu.demo.dto;

public record TestPersonInfo(String firstName, String lastName, Integer age){
    public TestPersonInfo withAge(Integer age) {
        return new TestPersonInfo(this.firstName, this.lastName, this.age);
    }
}
