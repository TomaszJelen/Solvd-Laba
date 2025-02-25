package solvd.laba.library.model;

public class Computer {
    private Long id;
    private String operatingSystem;
    private Long roomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
