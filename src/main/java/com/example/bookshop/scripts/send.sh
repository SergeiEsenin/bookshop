#!/bin/bash

TOKEN=630017124:AAF4yzwZG13Rf1qjOfpxBl7hn1m2lx-J9NA
CHAT_ID=198940192
MESSAGE="1"
URL="https://api.telegram.org/bot$TOKEN/sendMessage"

curl -s -X POST $URL -d chat_id=$CHAT_ID -d text="$MESSAGE"
