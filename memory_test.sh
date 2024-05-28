#!/bin/bash

# 앱을 실행하기 전 메모리 상태 확인
adb shell dumpsys meminfo > before_memory.txt

# 약간의 지연 시간
sleep 1

# 앱 실행
adb shell am start -n com.example.hiltmemoryanalyze/.MainActivity

# 약간의 지연 시간 후에 메모리 상태 확인
sleep 1

# 앱을 실행한 후 메모리 상태 확인
adb shell dumpsys meminfo > after_memory.txt

echo "메모리 상태 비교 결과:"
diff before_memory.txt after_memory.txt
