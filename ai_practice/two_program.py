import os
from openai import OpenAI

client = OpenAI(
    api_key=os.environ.get('DEEPSEEK_API_KEY'),
    base_url="https://api.deepseek.com",
)

response = client.chat.completions.create(
    model="deepseek-flash",
    messages=[
        {"role": "system", "content": "You are a helpful assistant"},
        {"role": "user", "content": "写一段800字的投资心得体会"},
    ],
    stream=True,
)

for chunk in response:
    text =  chunk.choices[0].delta.content
    if text:
        print(text,end='',flush=True)

