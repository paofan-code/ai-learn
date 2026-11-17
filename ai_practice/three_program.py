
'''
实现多轮对话
'''
import os

from openai import OpenAI
client = OpenAI(api_key=os.environ.get('DEEPSEEK_API_KEY'), base_url="https://api.deepseek.com")

# Round 1
messages = [{"role": "user", "content": "What's the highest mountain in the world?"}]
response = client.chat.completions.create(
    model="deepseek-flash",
    messages=messages,
)

messages.append(response.choices[0].message)
print(f"Messages Round 1: {messages}")

# Round 2
messages.append({"role": "user", "content": "What is the second?"})
response = client.chat.completions.create(
    model="deepseek-flash",
    messages=messages,
)

messages.append(response.choices[0].message)
print(f"Messages Round 2: {messages}")

messages.clear()

for msg in messages:
    if hasattr(msg,'content'):
        print(msg.content)
    else:
        print(msg)

while True:
    text = input("请输入您的问题？\n")
    if text == 'exit':
        break
    print("user:  ",text)
    msg = {'role':'user','content': text}
    messages.append(msg)
    response = client.chat.completions.create(
        model="deepseek-flash",
        messages=messages)
    llm_msg = response.choices[0].message
    print("deepseek:  ",llm_msg.content)
    messages.append(llm_msg)

