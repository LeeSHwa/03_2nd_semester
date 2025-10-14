using UnityEditor.Experimental.GraphView;
using UnityEngine;

public class ShootTranslate : MonoBehaviour
{
    float speed = 5.0f;
    public float power = 500.0f;
    public GameObject ball;
        

    // Update is called once per frame
    void Update()
    {
        float distance_per_frame = speed * Time.deltaTime;
        float vertical_input = Input.GetAxis("Vertical");
        float horizontal_input = Input.GetAxis("Horizontal");
        Vector3 launch_Direction = new Vector3(0, 1, 1);
        Vector3 launch_Direction_inv = new Vector3(0, 1, -1);


        transform.Translate(Vector3.forward * vertical_input * distance_per_frame);
        transform.Translate(Vector3.right * horizontal_input * distance_per_frame);

        if(Input.GetButtonDown("Fire1"))
            ball.GetComponent<Rigidbody>().AddForce(launch_Direction * power);
        else if(Input.GetButtonDown("Fire2"))
            ball.GetComponent<Rigidbody>().AddForce(launch_Direction_inv * power);
    }
}
