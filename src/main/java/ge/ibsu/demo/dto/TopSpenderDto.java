package ge.ibsu.demo.dto;

public class TopSpenderDto {
    private Long userId;
    private Double totalSpend;

    public TopSpenderDto(Long userId, Double totalSpend) {
        this.userId = userId;
        this.totalSpend = totalSpend;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Double getTotalSpend() {
        return totalSpend;
    }
    public void setTotalSpend(Double totalSpend) {
        this.totalSpend = totalSpend;
    }
}