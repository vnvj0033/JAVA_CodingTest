package codingstudy;

import java.util.Arrays;

public class CrackdownCamera {

    public int solution(int[][] routes) {

        Car[] cars = CreateCarData(routes);

        return countOfInstalledCamera(cars);
    }

    private Car[] CreateCarData(int[][] routes) {
        Car[] cars = new Car[routes.length];

        for (int i = 0; i < routes.length; i++) // routes배열을 Car 객체로 복사한다.
            cars[i] = new Car(routes[i][0], routes[i][1]);

        Arrays.sort(cars); // Car이 나가는 지점 순서로 정렬한다.
        return cars;
    }

    private int countOfInstalledCamera(Car[] cars) {
        int answer = 0;

        int min = -30000;

        for (Car car : cars) {
            if (min < car.enter) { // 나가는 지점과 다음 경로들의 시작점을 비교한다.
                answer++;   // 카메라를 추가한다.
                min = car.exit; // 다음 나가는 지점을 업데이트한다.
            }
        }
        return answer;
    }

    class Car implements Comparable<Car> { // Car는 enter, exit만 가지는 데이터 클래스
        int enter, exit;

        Car(int enter, int exit) {
            this.enter = enter;
            this.exit = exit;
        }


        @Override
        public int compareTo(Car o) { // 정렬시에는 나가는 지점을 기준으로 정렬
            return this.exit - o.exit;
        }
    }
}
