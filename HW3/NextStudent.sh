#!/bin/bash
OUTPUT="Start"

while true; do
  OUTPUT=$(python3 PlaceCodeInProject.py HW2)

  check=""

  if [ "$OUTPUT" == "${check}" ]; then
    echo Finished Running Unit Tests
    break
  fi

  check="Fix Error in File Location!"

  if [[ "$OUTPUT" == *"${check}" ]]; then
    echo $OUTPUT
    break
  fi

  echo $OUTPUT

  cd ../HW_Test

  echo Running Gradle
  gradle --rerun-tasks > ../HW2/counters/output.txt &

  PID2=$!
  count=0
  waittime=10
  while kill -0 $PID2 2> /dev/null; do
    sleep 1
    ((count++))
    if [ $count -gt $waittime ] ; then
      kill -TERM $PID2 2> /dev/null
      break
    fi
  done
  wait ${PID2}

  cd ../HW2

  OUTPUT=$(python3 GradleReader.py HW2)

  check="Did not compile or pass tests"

  if [ "$OUTPUT" == "${check}" ]; then
    cd ../HW_Test
    gradle cleanEclipse
    gradle eclipse
    cd ../HW_Student
    gradle cleanEclipse
    gradle eclipse
    cd ../HW2
    echo $OUTPUT
    break
  fi
done
