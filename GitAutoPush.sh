#!/bin/sh
#需求：实现GIT的定时自动提交代码
echo  `date +%y-%m-%d/%r` + "自动提交GIT"
git pull && git commit -a -m "git auto commit" & git push origin master:master
