#!/bin/bash

# 앱을 실행하기 전 메모리 상태 확인
adb shell dumpsys meminfo > before_memory.txt

# 약간의 지연 시간
sleep 1

# 앱 실행 [ com.example.hilt(싱글턴 테스트 모듈) / com.example.hilt_componenttree(상호참조 트리 테스트 모듈) / ]
# 원하는 모듈로 실행 시키기 위해서 위의 패키지 네임을 넣고 실행을 시켜야 함
adb shell am start -n com.example.hilt/.MainActivity

# 약간의 지연 시간 후에 메모리 상태 확인
sleep 0.01

# 앱을 실행한 후 메모리 상태 확인
adb shell dumpsys meminfo > after_memory.txt

echo "메모리 상태 비교 결과:"
diff before_memory.txt after_memory.txt

# 앱 종료 [ com.example.hilt(싱글턴 테스트 모듈) / com.example.hilt_componenttree(상호참조 트리 테스트 모듈) / ]
# 원하는 모듈로 실행 시키기 위해서 위의 패키지 네임을 넣고 실행을 시켜야 함
adb shell am force-stop com.example.hilt
