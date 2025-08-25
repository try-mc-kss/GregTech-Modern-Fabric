cd /mnt/e/dev/GregTech-Modern-fabric
jq 'keys' ./common/src/main/resources/assets/gtceu/lang/zh_cn.json > keys_zh.txt
jq 'keys' ./fabric/src/generated/resources/assets/gtceu/lang/en_us.json > keys_en.txt
diff keys_en.txt keys_zh.txt | grep '^<' > zh_less.txt
diff keys_en.txt keys_zh.txt | grep '^>' > zh_more.txt
# jq -S . ./common/src/main/resources/assets/gtceu/lang/zh_cn.json > sorted.json
