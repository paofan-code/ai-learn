from openai import OpenAI
import os
from dotenv import load_dotenv

load_dotenv()

client = OpenAI(
    api_key=os.environ.get('DEEPSEEK_API_KEY'),
    base_url="https://api.deepseek.com",
)

temperature_arr = [0,0.5,1.5]
'''
代码生成/数学解题 	0.0
数据抽取/分析	1.0
通用对话	1.3
翻译	1.3
创意类写作/诗歌创作	1.5
'''
for temperature in temperature_arr:
    for i in range(0,3):
        messages = [
            {"role": "system", "content": "You are a poet"},
            {"role": "user", "content": "请生成一首关于数学的诗歌,字数在50字之内"},
        ]
        response = client.chat.completions.create(
            model="deepseek-flash",
            temperature=temperature,
            messages=messages
        )
        print(temperature,"第",i,"首：")
        print(response.choices[0].message.content)
    print("**" * 20)
